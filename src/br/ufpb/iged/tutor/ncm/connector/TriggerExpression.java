
package br.ufpb.iged.tutor.ncm.connector;

/**
 *
 * @author GILBERTO FARIAS
 */
public class TriggerExpression implements ConditionExpression{
    long minDelay = 0;
    long maxDelay = 0;

    public long getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(long maxDelay) {
        this.maxDelay = maxDelay;
    }

    public long getMinDelay() {
        return minDelay;
    }

    public void setMinDelay(long minDelay) {
        this.minDelay = minDelay;
    }
}
