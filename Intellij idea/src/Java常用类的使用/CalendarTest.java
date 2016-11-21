package Java常用类的使用; /**
 * Created by Administrator on 2016/11/11 0011.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//2.使用Calendar优雅地输出我们这个Java课的课程计划（忽略国庆放假、运动会放假等），输出效果如下：
//10月03日 星期一(3,4)
//10月05日 星期三(3,4)
//10月07日 星期五(1,2)
//10月10日 星期一(3,4)
//10月12日 星期三(3,4)
//10月14日 星期五(1,2)
//10月17日 星期一(3,4)
//10月19日 星期三(3,4)
//10月21日 星期五(1,2)
//10月24日 星期一(3,4)
//10月26日 星期三(3,4)
//10月28日 星期五(1,2)
//10月31日 星期一(3,4)
//11月02日 星期三(3,4)
//11月04日 星期五(1,2)
//11月07日 星期一(3,4)
//11月09日 星期三(3,4)
//11月11日 星期五(1,2)
//11月14日 星期一(3,4)
//11月16日 星期三(3,4)
//11月18日 星期五(1,2)
//11月21日 星期一(3,4)
//11月23日 星期三(3,4)
//11月25日 星期五(1,2)

public class CalendarTest {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(2016, 9, 3);
        c2.set(2016, 10, 25);
        Date d1 = c1.getTime();
        Date d2 = c2.getTime();
        while (d2.after(d1)) {
            if (getWeekOfDate(d1).equals("星期一") || getWeekOfDate(d1).equals("星期三")) {
                String str = dateInfo(d1) + "(3,4)";
                System.out.println(str);

            } else if (getWeekOfDate(d1).equals("星期五")) {
                String str = dateInfo(d1) + "(1,2)";
                System.out.println(str);

            }
            d1 = addDateOneDay(d1);
        }

    }

    public static String dateInfo(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 EEEE");
        return sdf.format(date);

    }

    public static String getWeekOfDate(Date date) {
        String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (intWeek < 0) {
            intWeek = 0;
        }
        return weekDaysName[intWeek];
    }

    public static Date addDateOneDay(Date date) {
        if (null == date) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.DATE, 1); //日期加1天
        date = c.getTime();
        return date;
    }
}
