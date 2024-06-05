package org.bot4j.telegram.common;

import org.unify4j.model.builder.HttpStatusBuilder;
import org.unify4j.model.builder.WrapBuilder;
import org.unify4j.model.response.WrapResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TelegramClusters4j {
    private final List<Telegram4j> instances;

    public TelegramClusters4j(Builder builder) {
        this.instances = builder.instances;
    }

    /**
     * Sends multiple messages to the Telegram API.
     *
     * @return a List<WrapResponse<?>> containing the responses from the Telegram API for each message.
     */
    public List<WrapResponse<?>> sendMessage() {
        return instances.stream()
                .map(Telegram4j::sendMessage)
                .collect(Collectors.toList());
    }

    /**
     * Sends multiple messages to the Telegram API asynchronously.
     *
     * @return a CompletableFuture<List<WrapResponse<?>>> representing the asynchronous operation.
     */
    @SuppressWarnings({"SimplifyStreamApiCallChains"})
    public CompletableFuture<List<WrapResponse<?>>> sendMessageAsync() {
        List<CompletableFuture<WrapResponse<?>>> futures = instances.stream()
                .map(Telegram4j::sendMessageAsync)
                .collect(Collectors.toList());
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
    }

    /**
     * Sends multiple messages to the Telegram API silently (without waiting for the results).
     */
    public void sendMessageSilent() {
        instances.forEach(Telegram4j::sendMessageSilent);
    }

    /**
     * Sends multiple messages to the Telegram API and waits for the results.
     */
    public void sendMessageWait() {
        this.sendMessageAsync().join();
    }

    /**
     * Verifies all Telegram4j instances in the cluster.
     *
     * @return a WrapResponse<?> indicating the verification result.
     */
    public WrapResponse<?> verify() {
        for (Telegram4j instance : instances) {
            WrapResponse<?> verified = instance.verify();
            if (!verified.isSuccess()) {
                return verified;
            }
        }
        return new WrapBuilder<>().setStatusCode(HttpStatusBuilder.OK).build();
    }

    public static class Builder {
        protected List<Telegram4j> instances = new ArrayList<>();

        public TelegramClusters4j build() {
            return new TelegramClusters4j(this);
        }

        public Builder append(Telegram4j instance) {
            this.instances.add(instance);
            return this;
        }
    }
}
