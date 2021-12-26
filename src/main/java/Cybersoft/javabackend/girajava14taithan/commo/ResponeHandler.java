package Cybersoft.javabackend.girajava14taithan.commo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import Cybersoft.javabackend.girajava14taithan.commo.util.ErrorUtil;

public class ResponeHandler { // cau hinh lai cai responeEntity
	public static ResponseEntity<Object> getRespone(Object obj, HttpStatus status){
		boolean hasErrors = false;
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (obj instanceof BindingResult) {
			hasErrors = true;
		}
		
		if (hasErrors) {
			map.put("content", "");
			map.put("errors", ErrorUtil.solveError((BindingResult)obj));
		} else {
			map.put("content", obj);
			map.put("errors", "");
		}
		// contract with client
		map.put("hasErrors", hasErrors);
		map.put("pageIndex", 1);
		map.put("pageSize", 20);
		map.put("total", 20);
		map.put("responeTime", LocalDateTime.now().toLocalTime());
		map.put("httpStatus", status.value());
		
		return new ResponseEntity<Object>(map, status);
	}
}
