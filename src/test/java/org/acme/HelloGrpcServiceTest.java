package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Multi;

@QuarkusTest
public class HelloGrpcServiceTest {

    @GrpcClient
    HelloGrpc helloGrpc;

    @Test
    public void testHello() {
        HelloReply reply = helloGrpc
                .sayHello(HelloRequest.newBuilder().setName("Neo").build()).await().atMost(Duration.ofSeconds(5));
        assertEquals("Hello Neo!", reply.getMessage());
    }

    @Test
    public void testNumberStream() {
        Multi<NumberReply> reply = helloGrpc
                .streamRandomNumbers(NumberRequest.newBuilder().setCount(2).build());
        List<Long> values = reply.map(r -> r.getValue()).subscribe().asStream().collect(Collectors.toList());
        assertEquals(2, values.size());
        assertTrue(values.get(0) <= 100);
        assertTrue(values.get(0) >= 0);
        assertTrue(values.get(1) <= 100);
        assertTrue(values.get(1) >= 0);
    }

}
