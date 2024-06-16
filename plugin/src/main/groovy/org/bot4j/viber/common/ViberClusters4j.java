package org.bot4j.viber.common;

import org.unify4j.model.builder.HttpWrapBuilder;
import org.unify4j.model.response.WrapResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ViberClusters4j {
    private final List<Viber4j> instances;

    public ViberClusters4j(Builder builder) {
        this.instances = builder.instances;
    }

    /**
     * Sends multiple messages to the Slack API.
     *
     * @return a List<WrapResponse<?>> containing the responses from the Viber API for each message.
     */
    public List<WrapResponse<?>> sendMessage() {
        return instances.stream().map(Viber4j::sendMessage).collect(Collectors.toList());
    }

    /**
     * Sends multiple messages to the Viber API asynchronously.
     *
     * @return a CompletableFuture<List<WrapResponse<?>>> representing the asynchronous operation.
     */
    @SuppressWarnings({"SimplifyStreamApiCallChains"})
    public CompletableFuture<List<WrapResponse<?>>> sendMessageAsync() {
        List<CompletableFuture<WrapResponse<?>>> futures = instances.stream().map(Viber4j::sendMessageAsync).collect(Collectors.toList());
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
    }

    /**
     * Sends multiple messages to the Viber API silently (without waiting for the results).
     */
    public void sendMessageSilent() {
        instances.forEach(Viber4j::sendMessageSilent);
    }

    /**
     * Sends multiple messages to the Viber API and waits for the results.
     */
    public void sendMessageWait() {
        this.sendMessageAsync().join();
    }

    /**
     * Verifies all Viber instances in the cluster.
     *
     * @return a WrapResponse<?> indicating the verification result.
     */
    public WrapResponse<?> verify() {
        for (Viber4j instance : instances) {
            WrapResponse<?> verified = instance.verify();
            if (!verified.isSuccess()) {
                return verified;
            }
        }
        return new HttpWrapBuilder<>().ok(null).build();
    }

    public static class Builder {
        protected List<Viber4j> instances = new ArrayList<>();

        public ViberClusters4j build() {
            return new ViberClusters4j(this);
        }

        public Builder append(Viber4j instance) {
            this.instances.add(instance);
            return this;
        }
    }
}
