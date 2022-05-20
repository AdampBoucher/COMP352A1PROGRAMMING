public class Profiler {

    private String functionName;
    private long startTime;
    private long endTime;
    private long totalTime;



    public Profiler(String functionName){
        this.functionName = functionName;
        startTime = 0;
        endTime = 0;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
       endTime = System.nanoTime();
       totalTime = endTime - startTime;

       System.out.println("The function " + functionName + " took: " + totalTime);

    }
}
