package com.lance.test.core.stream;

/**
 * Created by perdonare on 2016/6/16.
 */
public class Streams {
    private enum Status {
        OPEN, CLOSED
    }

    ;

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }
}