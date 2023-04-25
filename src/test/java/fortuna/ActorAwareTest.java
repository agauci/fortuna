package fortuna;

import akka.actor.Terminated;
import akka.actor.testkit.typed.javadsl.ActorTestKit;
import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ActorAwareTest extends UnitTest {

    public static ActorTestKit testKit;

    public TestProbe<Terminated> actorLifecycleProbe;

    private List<ActorRef<?>> actorsCreated = new ArrayList<>();

    @Before
    public void ActorAwareTest_beforeTest() {
        if (testKit == null) {
            testKit = ActorTestKit.create();
        }

        actorLifecycleProbe = testKit.createTestProbe();
    }

    @After
    public void ActorAwareTest_afterTest() {
        actorsCreated.forEach(testKit::stop);
        actorLifecycleProbe.stop();
    }

    @AfterClass
    public static void ActorAwareTest_afterClass() {
        testKit.shutdownTestKit();
    }

    protected <T> ActorRef<T> track(final ActorRef<T> actorRef) {
        actorsCreated.add(actorRef);

        return actorRef;
    }

    protected <T> T awaitMessage(final TestProbe<?> testProbe, final Class<T> clazz, final Duration timeout) {
        Object message = testProbe.receiveMessage(timeout);
        assertThat(message).isInstanceOf(clazz);
        return clazz.cast(message);
    }

}
