package com.tiny.snake;import android.app.*;import android.graphics.*;import android.os.*;import android.view.*;public class MainActivity extends Activity implements View.OnTouchListener,Runnable{
int[] s=new int[400];int l=3,f=150,d=1,w=20,t,i;boolean o;Handler h=new Handler();View v;
protected void onCreate(Bundle b){super.onCreate(b);s[0]=210;s[1]=209;s[2]=208;
v=new View(this){protected void onDraw(Canvas c){c.drawColor(-16777216);Paint p=new Paint();t=getWidth()/w;
if(o){p.setColor(-65536);p.setTextSize(40);c.drawText("GAME OVER",20,100,p);return;}
p.setColor(-16711936);for(i=0;i<l;i++)c.drawRect((s[i]%w)*t,(s[i]/w)*t,(s[i]%w+1)*t,(s[i]/w+1)*t,p);
p.setColor(-65536);c.drawRect((f%w)*t,(f/w)*t,(f%w+1)*t,(f/w+1)*t,p);}};
setContentView(v);v.setOnTouchListener(this);h.postDelayed(this,150);}
public void run(){if(o)return;int n=s[0]+(d==1?1:d==-1?-1:d==20?20:-20);
if(n<0||n>=400||(d==1&&n%w==0)||(d==-1&&(n+1)%w==0))o=true;
for(i=0;i<l;i++)if(s[i]==n)o=true;
if(!o){System.arraycopy(s,0,s,1,l);s[0]=n;if(n==f){l++;f=(int)(Math.random()*400);}h.postDelayed(this,150);}
v.invalidate();}
public boolean onTouch(View v,MotionEvent e){if(e.getAction()==0){if(o){l=3;s[0]=210;s[1]=209;s[2]=208;d=1;o=false;h.postDelayed(this,150);return true;}
float x=e.getX()-v.getWidth()/2,y=e.getY()-v.getHeight()/2;
if(Math.abs(x)>Math.abs(y))d=x>0?1:-1;else d=y>0?20:-20;}return true;}}

