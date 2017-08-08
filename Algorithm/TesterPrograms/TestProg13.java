import utility.UtilityClass;
class TestProg13
{
	public static void main(String args[])
	{
		float p=Float.parseFloat(args[0]);
		float y=Float.parseFloat(args[1]);
		float R=Float.parseFloat(args[2]);
		UtilityClass.monthlyPayment(p, y, R);
	}
}