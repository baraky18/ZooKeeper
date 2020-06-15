package com.zookeeper.example;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ReadZNode {

	private static ZooKeeper zk;
	private static ZkConnector zkConnector;
	
	public static byte[] read(String path) throws KeeperException, InterruptedException{
		return zk.getData(path, true, zk.exists(path, true));
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		String path = "/sampleznode";
		zkConnector = new ZkConnector();
		zk = zkConnector.connect("localhost");
		byte[] data = read(path);
		for (byte b : data) {
			System.out.print((char)b);
		}
	}

}
