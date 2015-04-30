import java.util.Calendar;



public class Time {

	private int ss;
	private int mm;
	private int hh;
	private int dd;
	private int MM;
	private int YY;
	
	public Time(){}
	public Time(int ss,int mm,int hh,int dd,int MM,int YY){
		this.ss=ss;
		this.mm=mm;
		this.hh=hh;
		this.dd=dd;
		this.MM=MM;
		this.YY=YY;
		
	}
	public int getSs() {
		return ss;
	}
	public void setSs(int ss) {
		this.ss = ss;
	}
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getHh() {
		return hh;
	}
	public void setHh(int hh) {
		this.hh = hh;
	}
	public int getDd() {
		return dd;
	}
	public void setDd(int dd) {
		this.dd = dd;
	}
	public int getMM() {
		return MM;
	}
	public void setMM(int mM) {
		MM = mM;
	}
	public int getYY() {
		return YY;
	}
	public void setYY(int yY) {
		YY = yY;
	}
	
	public static Time now(){
		Calendar rightNow = Calendar.getInstance();
		Time t = new Time();
		t.hh = rightNow.get(Calendar.HOUR_OF_DAY);
		t.mm = rightNow.get(Calendar.MINUTE);
		t.ss = rightNow.get(Calendar.SECOND);
		t.MM = rightNow.get(Calendar.MONTH)+1;
		t.dd = rightNow.get(Calendar.DATE);
		t.YY = rightNow.get(Calendar.YEAR);
		return t;
	}
	
	@Override
	public String toString(){
		String result = String.format("%d:%d:%d %d.%d.%d",hh,mm,ss,dd,MM,YY);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t = new Time(12,28,23,12,12,2015);
		System.out.println(t);
		System.out.println(now());
	}

}
