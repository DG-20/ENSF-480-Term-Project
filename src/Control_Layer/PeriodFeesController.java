/*
 * File Name: PeriodFeesController.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Control_Layer;

import Data_Source_Layer.*;

/**
 * PeriodFeesController is a class which inherits from Controller.
 * This class communicates with PaymentPeriodRecord and is used
 * when updating/retrieving the info of the payment period or amount.
 */
public class PeriodFeesController extends Controller {

    /*
     * Default constructor for PeriodFeesController
     */
    public PeriodFeesController() {
        Database data = new PaymentPeriodRecord();
        myData.add(data);
    }

    /* Asks the DB for the current period */
    public int sendPeriod() {
        Database d = myData.get(0);
        PaymentPeriodRecord record = (PaymentPeriodRecord) d;
        return record.retrievePeriod();
    }

    /**
     * @param fee
     * @param period
     * @return
     */
    public void forwardPeriodFees(int fee, int period) {
        // TODO implement here
        Database d = myData.get(0);
        PaymentPeriodRecord record = (PaymentPeriodRecord) d;
        record.updatePeriodPayment(fee, period);
        return;
    }

    /**
     * @return
     */
    public int sendPayment() {
        // TODO implement here
        Database d = myData.get(0);
        PaymentPeriodRecord record = (PaymentPeriodRecord) d;
        return record.retrievePayment();
    }
}