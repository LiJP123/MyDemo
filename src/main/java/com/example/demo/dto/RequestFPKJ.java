package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


/**
 * fm_invoiceDTO类
 * <p></p>
 *
 * @author Ljp
 * @since 2020-03-18T15:32:40.09
 */

@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
// XML文件中的根标识
@XmlRootElement(name = "requestFPKJ")
public class RequestFPKJ implements Serializable{

    private static final long serialVersionUID=1L;
    /**
     * 流水号 发票请求流水号（订单号），订单唯一标识
     */
    private String swno;
    /**
     * 组织代码
     */
    private String sellerTaxNo;
    /**
     * 发票抬头
     */
    private String custName;
    /**
     * 购方税号
     */
    private String custTaxNo;
    /**
     * 购方地址电话
     */
    private String custAddrPhone;
    /**
     *购方银行账号
     */
    private String custBankAccount;
    /**
     * 购方手机
     */
    private String custTelephone;
    /**
     * 购方邮箱
     */
    private String custEmail;
    /**
     * 发票备注
     */
    private String invMemo;
    /**
     * 发票类型
     */
    private String invType;
    /**
     * 订单日期
     */
    private String orderDate;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 开票人
     */
    private String drawer;
    /**
     * 复核人
     */
    private String reviewer;
    /**
     * 收款人
     */
    private String payee;
    /**
     * 原发票代码
     */
    private String origInvcode;
    /**
     * 原发票号码
     */
    private String origInvno;
    /**
     *  红字通知表编号
     */
    private String redCode;
    /**
     * 销方地址电话
     */
    private String sellerAddrPhone;
    /**
     * 销方银行账号
     */
    private String sellerBankAccount;
    /**
     * 开票机号
     */
    private String machineCode;
    /**
     * 成品油标识
     */
    private String oilIdentification;
    /**
     * 开票类型
     */
    private String kpType;
    /**
     * 结果代码
     */
    private String returnCode;
    /**
     * returnMessage
     */
    private String returnMessage;
    private Items items;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @ToString(callSuper = true)
    public static class Items {
        private List<Item> item;

        @Getter
        @Setter
        @RequiredArgsConstructor
        @ToString(callSuper = true)
        public static class Item {
            /**
             * 发票行性质
             */
            private String lineType;
            /**
             * 明细行号
             */
            private String lineCode;
            /**
             * 商品名称
             */
            private String goodsName;
            /**
             * 规格型号
             */
            private String model;
            /**
             * 计量单位
             */
            private String unit;
            /**
             * 数量
             */
            private String qty;
            /**
             * 单价
             */
            private String price;
            /**
             * 含税单价
             */
            private String taxPrice;
            /**
             * 金额
             */
            private String amount;
            /**
             * 含税金额
             */
            private String taxAmount;
            /**
             * 税额
             */
            private String tax;
            /**
             * 税率
             */
            private String taxRate;
            /**
             * 税收分类编码
             */
            private String taxCode;
            /**
             * 优惠政策标识
             */
            private String taxPre;
            /**
             * 增值税特殊管理（优惠政策内容）
             */
            private String taxPrecon;
            /**
             * 零税率标识
             */
            private String zeroTax;
            /**
             * 自行编码
             */
            private String gropGoodsNo;
            /**
             * 扣除额
             */
            private String taxDeduction;
            /**
             * 税收分类编码版本号
             */
            private String taxVersion;
        }
    }
}
