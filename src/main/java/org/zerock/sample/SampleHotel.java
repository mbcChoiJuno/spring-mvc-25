package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor // 모든 필드값을 이용해서 생성자 주입
@RequiredArgsConstructor
public class SampleHotel {
	private Chef chef;
	private Restaurant restaurant;
	
	private String name;
}
