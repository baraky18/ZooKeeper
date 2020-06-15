package com.zookeeper.example;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class UpdateZNode {

	private static ZooKeeper zk;
	private static ZkConnector zkConnector;
	
	public static void update(String path, byte[] data) throws KeeperException, InterruptedException{
		zk.setData(path, data, zk.exists(path, true).getVersion());
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		String path = "/sampleznode";
		byte[] data = "I am updated now".getBytes();
		zkConnector = new ZkConnector();
		zk = zkConnector.connect("localhost");
		update(path, data);
	}
}
