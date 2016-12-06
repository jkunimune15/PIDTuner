import java.util.Random;

/**
 * Created by serena on 12/4/16.
 */
public class PIDTuner {
    private final PID pid;
    private final InvertedPendulum pendulum;
    private final Random random = new Random();

    public static final int TIMEOUT_TIME_STEPS = 10_000; //ms
    private static final int NUM_TESTS = 10_000;

    private double[] dterms = new double[NUM_TESTS], pterms = new double[NUM_TESTS],
            iterms = new double[NUM_TESTS], ibounds = new double[NUM_TESTS],
            score = new double[NUM_TESTS];

    public static final double D_UPPER = 100.0, D_LOWER = -100.0, D_RANGE = D_UPPER-D_LOWER;
    public static final double P_UPPER = 100.0, P_LOWER = -100.0, P_RANGE = P_UPPER-P_LOWER;
    public static final double I_UPPER = 100.0, I_LOWER = -100.0, I_RANGE = I_UPPER-I_LOWER;
    public static final double I_BOUND_UPPER = 100.0, I_BOUND_LOWER = -100.0, I_BOUND_RANGE = I_BOUND_UPPER-I_BOUND_LOWER;

    public PIDTuner(PID pid, InvertedPendulum pendulum){
        this.pid = pid;
        this.pendulum = pendulum;
    }

    public void trainPID(){
        for(int j = 0; j<NUM_TESTS; j++){
            double d = random.nextDouble()*D_RANGE+D_LOWER;
            double p = random.nextDouble()*P_RANGE+P_LOWER;
            double i = random.nextDouble()*I_RANGE+I_LOWER;
            double bound = random.nextDouble()*I_BOUND_RANGE+I_BOUND_LOWER;

            pid.setConstants(d,p,i,bound);

            dterms[j] = d;
            pterms[j] = p;
            iterms[j] = i;
            ibounds[j] = bound;

            double totalErrorAbs = 0.0;

            //simulate, with drawing?

        }
    }

}