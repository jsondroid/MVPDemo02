package jsondroid.android.com.mvpdemo02.retrofit;

/**
 * Created by wenbaohe on 2017/11/24.
 */

public interface ServiceRXURL {
    //    public static final String SERVER_ADDRESS = "http://192.168.0.10:8080/";//本地服务
    public static final String SERVER_ADDRESS = "http://118.190.117.156:8080/";//外网
    //    public static final String SERVER_ADDRESS = "http://118.190.117.156:9090/";//外网
    public static final String Register_PATH = "/v1/register";
    public static final String getcode_PATH = "/v1/getcode";
    public static final String getPAWD_PATH = "/v1/recoverpwd ";
    public static final String LOGIN_PATH = "/v1/login";
    public static final String LOGINOut_PATH = "/v1/loginout";
    public static final String ALL_PATH = "/v1/members/all";
    public static final String Customer_PATH = "/v1/members/get";
    public static final String Customerdelect_PATH = "/v1/members/del";
    public static final String CustomerAdd_PATH = "/v1/members/add";//旧版
    public static final String CustomerAddNEW_PATH = "/v1/members/addandanswer";//新版
    public static final String CustomerEdt_PATH = "/v1/members/edit";

    public static final String QUESTTION_PATH = "/v1/question/get";
    public static final String SUBMINTQUEST_PATH = "/v1/question/answer";

    public static final String JUDGESTSTATUS_PATH = "/v1/members/judgestatus";

//    public static final String TESTREPORT_PATH = "/v1/skintest/gettestreport";//老接口
    public static final String TESTREPORT_PATH = "/v1/skintest/testallindex";//新接口

    public static final String BLOOD_OXYGEN_PATH = "/v1/skintest/blood_oxygen";
    public static final String COMPRE_PATH = "/v1/skintest/total";
    public static final String SOLUTION_PATH = "/v1/skintest/getsolution";
    public static final String Products_PATH = "/v1/skintest/getproduct";//getproduct
    public static final String ProductsADD_PATH = "/v1/skintest/addbought";
    public static final String Report_PATH = "/v1/skintest/savereport";//getproduct
    public static final String Productdetail_PATH = "/v1/skintest/productdetail";

    public static final String Weather_PATH = "/v1/env";
    public static final String History_PATH = "/v1/skintest/history";
    public static final String Getonehistory_PATH = "/v1/skintest/getreporthistory";
}
