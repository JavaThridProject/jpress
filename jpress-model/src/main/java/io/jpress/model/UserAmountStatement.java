package io.jpress.model;

import io.jboot.db.annotation.Table;
import io.jpress.model.base.BaseUserAmountStatement;

/**
 * Generated by JPress.
 */
@Table(tableName = "user_amount_statement", primaryKey = "id")
public class UserAmountStatement extends BaseUserAmountStatement<UserAmountStatement> {

    private static final long serialVersionUID = 1L;

    public static final String ACTION_PAY_ORDER = "pay_order";//支付订单（支出）
    public static final String ACTION_PAYOUT = "payout";//提现（支出）
    public static final String ACTION_RECHARGE = "recharge";//充值（收入）
    public static final String ACTION_DIST = "dist"; //分销（收入）


}
