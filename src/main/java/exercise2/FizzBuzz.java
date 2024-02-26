package exercise2;

class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() {
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                System.out.print("fizz, ");
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() {
        while (i <= n) {
            if (i % 5 == 0 && i % 3 != 0) {
                System.out.print("buzz, ");
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("fizzbuzz, ");
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    
    public synchronized void number() {
        while (i <= n) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i + ", ");
                ;
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread thread1 = new Thread(fizzBuzz::fizz);
        Thread thread2 = new Thread(fizzBuzz::buzz);
        Thread thread3 = new Thread(fizzBuzz::fizzbuzz);
        Thread thread4 = new Thread(fizzBuzz::number);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}


