package rest.example.rest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rest.example.rest.model.Event;
import rest.example.rest.model.LogEvent;
import rest.example.rest.msg.AddEventRequest;
import rest.example.rest.repository.LogEventRepository;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@EnableAspectJAutoProxy
@Aspect
@Component
public class EventLogAspect {

    //@Around je mesavina @Before i @After
    //before je sve pre theProceedingJoinPoint.proceed(), onda ide da odradi metodu
    //koju gadjam, pa se vraca, a sav kod posle theProceedingJoinPoint.proceed() je after

    @Autowired
    private LogEventRepository logEventRepository;

    @Pointcut("execution(* rest.example.rest.restController.OrganizerController.addOrganizer(..))")
    private void forControllerPackage() {}




    @Pointcut("execution(* rest.example.rest.restController.EventController.addEvent(..))")
    private void forEventController() {}



    @Pointcut("execution(* rest.example.rest.restController.ParticipantController.addParticipant(..))")
    private void forParticipantController() {}

    @Pointcut("execution(* rest.example.rest.restController.VenueController.addVenue(..))")
    private void forVenueController() {}

    //presrecemo metodu organizer kontrolera "addOrganizer()" kako bi logovali to da smo ga dodali u tabeli LogEvent
    @Around("forControllerPackage()")
    public Object aroundLogEventToDbForOrganizer(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        // begin
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Test time1 " + dateFormat.format(date)); //2016-11-16 12:08:43

        String dateTime = dateFormat.format(date).toString();
        System.out.println("Test time2 " + dateTime);



        //event tabela po name-u, ako je razlicito od ona 3 ili ako je stiglo kao null, onda je
        //status failed






        LogEvent logEvent = LogEvent.LogEventBuilder.anLogEvent().withDescription("user has added new organizer")
                .withCategory("add new").withStatus("successful").withDateTime(dateTime).build();

        logEventRepository.save(logEvent);

        return theProceedingJoinPoint.proceed();        //ako nije true nastavi sa metodom kontrolera
        //koju presecamo, a ona ce svakako vratiti home page, tj prvu stranicu
    }

    //presrecemo metodu organizer kontrolera "addEvent()" kako bi logovali to da smo ga dodali u tabeli LogEvent
    @Around("forEventController()")
    public Object aroundLogEventToDbForEvent(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method:  " + method);

        /*Object[] methodArguments = theProceedingJoinPoint.getArgs();
        Object arg= methodArguments[0];*/

        //get name from object AddEventRequest that i receive via @RequestBody in RestController method
        AddEventRequest addEventRequest = (AddEventRequest) theProceedingJoinPoint.getArgs()[0];
        String name = addEventRequest.getName();
        System.out.println(name);

            Object result = theProceedingJoinPoint.proceed();//IDI ODMA NA TU METODU, PA POSLE TE METODE DODJI OVDE NA PROVERU

            // begin
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            System.out.println("Test time1 " + dateFormat.format(date)); //2016-11-16 12:08:43

            String dateTime = dateFormat.format(date).toString();
            System.out.println("Test time2 " + dateTime);

            //event tabela po name-u, ako je razlicito od ona 3 ili ako je stiglo kao null, onda je
            //status failed

            //if "name" from db table "event" is not "it conference" or "meeting" or "solutions"
            //then log in LogEvent table in db as status "failed"
            if( !( name.equalsIgnoreCase("it conference") || name.equalsIgnoreCase("meeting")
                                || name.equalsIgnoreCase("solutions"))  ) {
                LogEvent logEvent = LogEvent.LogEventBuilder.anLogEvent().withDescription("user has added new event")
                        .withCategory("add new").withStatus("failed").withDateTime(dateTime).build();
                logEventRepository.save(logEvent);
            }else {//otherwise, log in db table LogEvent status "successful"
                LogEvent logEvent = LogEvent.LogEventBuilder.anLogEvent().withDescription("user has added new event")
                        .withCategory("add new").withStatus("successful").withDateTime(dateTime).build();
                logEventRepository.save(logEvent);
            }

            return result;
    }

    //presrecemo metodu participant kontrolera "addParticipant()" kako bi logovali to da smo ga dodali u tabeli LogEvent
    @Around("forParticipantController()")
    public Object aroundLogEventToDbForParticipant(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method:   " + method);

        // begin
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Test time1 " + dateFormat.format(date)); //2016-11-16 12:08:43

        String dateTime = dateFormat.format(date).toString();
        System.out.println("Test time2 " + dateTime);

        LogEvent logEvent = LogEvent.LogEventBuilder.anLogEvent().withDescription("user has added new participant")
                .withCategory("add new").withStatus("successful").withDateTime(dateTime).build();

        logEventRepository.save(logEvent);

        return theProceedingJoinPoint.proceed();        //ako nije true nastavi sa metodom kontrolera
        //koju presecamo, a ona ce svakako vratiti home page, tj prvu stranicu
    }

    //presrecemo metodu venue kontrolera "addVenue()" kako bi logovali to da smo ga dodali u tabeli LogEvent
    @Around("forVenueController()")
    public Object aroundLogEventToDbForVenue(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method:    " + method);

        // begin
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Test time1 " + dateFormat.format(date)); //2016-11-16 12:08:43

        String dateTime = dateFormat.format(date).toString();
        System.out.println("Test time2 " + dateTime);

        LogEvent logEvent = LogEvent.LogEventBuilder.anLogEvent().withDescription("user has added new venue")
                .withCategory("add new").withStatus("successful").withDateTime(dateTime).build();

        logEventRepository.save(logEvent);

        return theProceedingJoinPoint.proceed();        //ako nije true nastavi sa metodom kontrolera
        //koju presecamo, a ona ce svakako vratiti home page, tj prvu stranicu
    }

}
