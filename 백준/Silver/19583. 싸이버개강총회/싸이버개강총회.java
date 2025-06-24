

import java.util.*;
import java.io.*;

class Main
{
	
	public static class Time implements Comparable<Time>{
		int hour, min;
		public Time(int hour, int min) {
			this.hour = hour;
			this.min = min;
		}
		// 양수 반환 : 이 시간이 다른 시간보다 크다, 눚다
		@Override
		public int compareTo(Time o) {
			if(this.hour != o.hour) {
				return Integer.compare(this.hour, o.hour);
			}
			return Integer.compare(this.min, o.min);
		}
		
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Time start = parseTime(st.nextToken());
		Time end = parseTime(st.nextToken());
		Time streamEnd = parseTime(st.nextToken());
		
		Set<String> entered = new HashSet<>();
		Set<String> checked = new HashSet<>();
		
		String line = "";
		while ((line = br.readLine()) != null && !line.isEmpty())  {
			String[] token = line.split(" ");
			Time now = parseTime(token[0]);
			
			// 만약 start보다 이른 시간이면 entered에 유저닉네임 추가
			if(now.compareTo(start) <= 0) {
				entered.add(token[1]);
				continue;
			}
			// end보다 늦고 streamEnd 이전이면 entered에 존재하는지 확인
			// 존재하면 checked에 넣기
			if(now.compareTo(end)>=0 && now.compareTo(streamEnd) <= 0) {
				if(entered.contains(token[1])) {
					checked.add(token[1]);
				}
			}
			
		}
		
//		for(String str : checked) {
//			System.out.println(str);
//		}
		System.out.println(checked.size());
		
	}	
	
	// int[]가 아니라 class를 만드는게 낫나..? 
	public static Time parseTime(String time) {
		int[] parsedTime = new int[2];
		int idx=0;
		String[] times = time.split(":");
		return new Time(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
		
	}
	

}
