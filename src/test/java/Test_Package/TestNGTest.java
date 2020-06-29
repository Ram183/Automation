package Test_Package;

import org.testng.annotations.Test;

public class TestNGTest {

	@Test(dependsOnMethods="Method1")
	public void method3()
	{
	System.out.println("Hai");
	}
	@Test(enabled=true)
	public void Method1()
	{
	System.out.println("How");
	}
	@Test()
	public void Method2()
	{
	System.out.println("Are");
	}

}
