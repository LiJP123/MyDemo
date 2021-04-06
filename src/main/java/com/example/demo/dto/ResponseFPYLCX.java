package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@XmlRootElement(name = "responseFPYLCX")
public class ResponseFPYLCX {
    /**
     * 组织代码
     */
    private String sellerTaxNo;
    /**
     * 结果代码
     */
    private String returnCode;
    /**
     * 结果描述
     */
    private String returnMessage;
    private List<Machines> machines;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @ToString(callSuper = true)
    public static class Machines {
        private List<Machine> machine;

        @Getter
        @Setter
        @RequiredArgsConstructor
        @ToString(callSuper = true)
        public static class Machine {
            /**
             * 开票机号
             */
            private String machineCode;
            private List<InvSurpluss> invSurpluss;


            @Getter
            @Setter
            @RequiredArgsConstructor
            @ToString(callSuper = true)
            public static class InvSurpluss {
                private List<InvSurplus> invSurplus;

                @Getter
                @Setter
                @RequiredArgsConstructor
                @ToString(callSuper = true)
                public static class InvSurplus {
                    /**
                     * 发票类型
                     */
                    private String invType;
                    /**
                     * 发票剩余量
                     */
                    private String invQty;
                }
            }
        }
    }

}
