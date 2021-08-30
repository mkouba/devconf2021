package org.acme;

import java.time.Duration;
import java.util.Random;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

    @Override
    public Multi<NumberResponse> streamRandomNumbers(NumberRequest request) {
        Random random = new Random();
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1)).select().first(request.getCount()).map(tick -> {
            return NumberResponse.newBuilder().setIndex(tick + 1).setValue(random.nextInt(100)).build();
        });
    }

}
