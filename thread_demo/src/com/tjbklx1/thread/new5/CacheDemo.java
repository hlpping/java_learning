package com.tjbklx1.thread.new5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

/**
 * 自定义缓存
 * @author shuang
 * @date Nov 5, 2011
 */
public class CacheDemo {
	private Map<String, Object> cache =new HashMap<String, Object>();
	@Test
	public void testname() throws Exception {
		//map中没有数据 无法测试
		getData("1");
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
			}
		}finally{
			lock.readLock().unlock();
		}
		return value;
	}
}
