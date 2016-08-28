package com.tjbklx1.thread.new5.demo04.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 自定义缓存
 * @author shuang
 * @date Nov 5, 2011
 */
public class CacheDemo {
	private Map<String, Object> cache =new HashMap<String, Object>();
	
	public static void main(String[] args) {
		
		//map中没有数据 无法测试
		new CacheDemo().getData("1");
	}
	
	
	private ReadWriteLock lock=new ReentrantReadWriteLock();
	
	public Object getData(String key){
		lock.readLock().lock();
		Object value=null;
		try{
			value=cache.get(key);
			if(value==null){
				lock.readLock().unlock();
				lock.writeLock().lock();
				try{
					if(value==null)
						value="aaaaaa";
				}finally{
					lock.writeLock().unlock();
				}
//				lock.readLock().unlock();
			}
		}finally{
			lock.readLock().unlock();
		}
		return value;
	}
}
