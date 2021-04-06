package com.example.demo.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <p></p>
 *
 * @author Ljp
 * @since 2020-04-21
 */
// XML文件中的根标识
@XmlRootElement(name = "responseFPXZ")
// 控制JAXB 绑定类中属性和字段的排序
public class ResponseFPXZ {

    /**
     * 	发票请求唯一流水号
     */
    private String swno;
    /**
     * 	组织代码
     */
    private String sellerTaxNo;
    /**
     *	结果代码
     */
    private String returnCode;
    /**
     *	结果描述
     */
    private String returnMessage;
    private InvoiceInfos invoiceInfos;

    public String getSwno() {
        return swno;
    }

    public void setSwno(String swno) {
        this.swno = swno;
    }

    public String getSellerTaxNo() {
        return sellerTaxNo;
    }

    public void setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public InvoiceInfos getInvoiceInfos() {
        return invoiceInfos;
    }

    public void setInvoiceInfos(InvoiceInfos invoiceInfos) {
        this.invoiceInfos = invoiceInfos;
    }

    @Override
    public String toString() {
        return "ResponseFPXZ{" +
                "swno='" + swno + '\'' +
                ", sellerTaxNo='" + sellerTaxNo + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                ", invoiceInfos=" + invoiceInfos +
                '}';
    }

    public static class InvoiceInfos {
        private List<InvoiceInfo> invoiceInfo;

        public List<InvoiceInfo> getInvoiceInfo() {
            return invoiceInfo;
        }

        public void setInvoiceInfo(List<InvoiceInfo> invoiceInfo) {
            this.invoiceInfo = invoiceInfo;
        }

        @Override
        public String toString() {
            return "InvoiceInfos{" +
                    "invoiceInfo=" + invoiceInfo +
                    '}';
        }

        public static class InvoiceInfo {
            /**
             *	发票代码
             */
            private String invCode;
            /**
             *	发票号码
             */
            private String invNo;
            /**
             *	开票时间
             */
            private String invDate;
            /**
             *	合计金额
             */
            private String totalAmount;
            /**
             *	合计税额
             */
            private String totalTax;
            /**
             *	pdf文件
             */
            private String pdfContent;

            public String getInvCode() {
                return invCode;
            }

            public void setInvCode(String invCode) {
                this.invCode = invCode;
            }

            public String getInvNo() {
                return invNo;
            }

            public void setInvNo(String invNo) {
                this.invNo = invNo;
            }

            public String getInvDate() {
                return invDate;
            }

            public void setInvDate(String invDate) {
                this.invDate = invDate;
            }

            public String getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(String totalAmount) {
                this.totalAmount = totalAmount;
            }

            public String getTotalTax() {
                return totalTax;
            }

            public void setTotalTax(String totalTax) {
                this.totalTax = totalTax;
            }

            public String getPdfContent() {
                return pdfContent;
            }

            public void setPdfContent(String pdfContent) {
                this.pdfContent = pdfContent;
            }

            @Override
            public String toString() {
                return "InvoiceInfo{" +
                        "invCode='" + invCode + '\'' +
                        ", invNo='" + invNo + '\'' +
                        ", invDate='" + invDate + '\'' +
                        ", totalAmount='" + totalAmount + '\'' +
                        ", totalTax='" + totalTax + '\'' +
                        ", pdfContent='" + pdfContent + '\'' +
                        '}';
            }
        }
    }
}
