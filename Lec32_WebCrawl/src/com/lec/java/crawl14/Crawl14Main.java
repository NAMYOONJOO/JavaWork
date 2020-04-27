package com.lec.java.crawl14;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/6561536751626864373042464d4356/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/6561536751626864373042464d4356/json/CardSubwayStatsNew/1/5/20181001 
 * */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습 : URL -> json -> Java");

		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL("http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001");
		
		Subway subway = mapper.readValue(url, Subway.class);
		
		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());
		
		for(SubRow e : subway.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", 
					e.getLineNum(), 
					e.getStationName(), 
					e.getRidePaserNum(), 
					e.getAlightPaserNum());
		}
		
		System.out.println("\n프로그램 종료");
		
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{
	//CardSubwayStatsNew
	public Stats CardSubwayStatsNew;

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		CardSubwayStatsNew = cardSubwayStatsNew;
	}
	
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Stats{
	int list_total_count;
	private List<SubRow> row;
	
	public List<SubRow> getRow() {
		return row;
	}

	public void setRow(List<SubRow> row) {
		this.row = row;
	}

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
 
}
//JSON필드명과 매핑되는 JAVA객체의 변수명을 달리 하고 싶다면
//@JsonProperty 사용
@JsonIgnoreProperties(ignoreUnknown = true)

class SubRow{
	@JsonProperty("LINE_NUM")// Json의 LINE_NUM--->lineNum으로 매핑
	private String lineNum;
	
	@JsonProperty("SUB_STA_NM")
	private String stationName;
	
	@JsonProperty("RIDE_PASGR_NUM")
	private int ridePaserNum;
	
	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightPaserNum;

	public SubRow(String lineNum, String stationName, int ridePaserNum, int alightPaserNum) {
		super();
		this.lineNum = lineNum;
		this.stationName = stationName;
		this.ridePaserNum = ridePaserNum;
		this.alightPaserNum = alightPaserNum;
	}

	public SubRow() {
		super();
	}

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getRidePaserNum() {
		return ridePaserNum;
	}

	public void setRidePaserNum(int ridePaserNum) {
		this.ridePaserNum = ridePaserNum;
	}

	public int getAlightPaserNum() {
		return alightPaserNum;
	}

	public void setAlightPaserNum(int alightPaserNum) {
		this.alightPaserNum = alightPaserNum;
	}

	
	
	
	
	
	
}