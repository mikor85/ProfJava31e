package lesson4.card;

public class Card {
    private String holder;
    private double balance;
    private CardStatus status;

    public enum CardStatus {
        ORDERED(5) {
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        CardStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        public boolean isOrdered() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }
    } // окончание CardStatus

    public boolean isDeliverable() {
        return status.isReady();
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

} // окончание Card
