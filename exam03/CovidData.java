package exam03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

import exam03.CovidDto.Response.Body.Items;
import exam03.CovidDto.Response.Body.Items.Item;

public class CovidData {
    public static List<Item> getCovidList(
            String StateDt,
            String UpdateDt) {
        String covidUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=10"
                + "&startCreateDt=" + StateDt
                + "&endCreateDt=" + UpdateDt + "&_type=json";
        try {
            URL url = new URL(covidUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            CovidDto dto = gson.fromJson(responseJson, CovidDto.class);

            List<Item> result = dto.getResponse().getBody().getItems().getItem();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회중 오류가 발생했습니다.");
        }
        return null;
    }

}
