package CommonMethods;


import java.util.List;
import java.util.stream.Collectors;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;


public class SkippingMethods extends TestBase implements IMethodInterceptor{
	
	public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
	
		return list.stream()
                .filter(instance ->
                        !isSkippable(instance.getMethod().getMethodName()))
                .collect(Collectors.toList());
		
	}
	
	
	private boolean isSkippable(String methodName) {
		String flag=ReadExcel().get(methodName);
		
			if(flag.equalsIgnoreCase("N")) {
	            return true;
	        }
	        return false;
	
        
    }

}
