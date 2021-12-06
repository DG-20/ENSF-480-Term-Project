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

import java.util.*;

/**
 * 
 */
public class PeriodFeesController extends Controller {

    /**
     * Default constructor
     */
    public PeriodFeesController() {
        Database data = new PaymentPeriodRecord();
        myData.add(data);
    }


    /**
     * @param fee 
     * @param period 
     * @return
     */
    public void forwardPeriodFees(int fee, int period) {
        // TODO implement here
        Database d = myData.get(0);
        PaymentPeriodRecord record = (PaymentPeriodRecord)d;
        record.updatePeriodPayment(fee, period);
        return;
    }

    /**
     * @return
     */
    public int sendPayment() {
        // TODO implement here
        Database d = myData.get(0);
        PaymentPeriodRecord record = (PaymentPeriodRecord)d;
        return record.retrievePayment();
    }


}