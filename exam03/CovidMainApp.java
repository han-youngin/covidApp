package exam03;

import java.util.List;
import java.util.Scanner;

import javax.swing.SortingFocusTraversalPolicy;

import exam03.CovidDto.Response.Body.Items.Item;

public class CovidMainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====시작 날짜를 입력하세요.====");
        String StateDt = sc.nextLine();
        System.out.println("====종료 날짜를 입력하세요.====");
        String UpdateDt = sc.nextLine();

        List<Item> result = CovidData.getCovidList(StateDt, UpdateDt);

        for (int i = result.size() - 1; i > 0; i--) {
            System.out.println(result.get(i).getStateDt() + "의 코로나 현황");
            System.out.println("확진자 수:" + result.get(i).getDecideCnt());
            System.out.println("사망자 수:" + result.get(i).getDeathCnt());

        }

    }
}
