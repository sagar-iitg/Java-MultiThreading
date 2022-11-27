package com.sk.thread;

import java.math.BigInteger;

public class Example6
{


    public static void main(String[] args)
    {

//        Thread t=new Thread(new LongComputationTask(new BigInteger("2"),new BigInteger("10")));
//        t.start();
        Thread t1=new Thread(new LongComputationTask(new BigInteger("2000"),new BigInteger("10000")));
        t1.start();

    }

    private static class LongComputationTask implements  Runnable
    {

        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power)
        {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run()
        {

            System.out.println(base+ "^"+power +" -- " +pow(base,power));
        }

        private BigInteger pow(BigInteger base,BigInteger power)
        {

            BigInteger result=BigInteger.ONE;
            for(BigInteger i=BigInteger.ZERO; i.compareTo(power)!=0;i=i.add(BigInteger.ONE))
            {


                if(Thread.currentThread().isInterrupted())
                {
                    System.out.println("Prematurely Interrupted");
                    return  BigInteger.ZERO;
                }
                result=result.multiply(base);
            }
            return result;

        }
    }
}
