package com.zookeeper.example;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class GetACL {

	private static ZooKeeper zk;
	private static ZkConnector zkConnector;
	
	private static List<ACL> getAcl(String path) throws KeeperException, InterruptedException{
		return zk.getACL(path, zk.exists(path, true));
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		String path = "/sampleznode";
		zkConnector = new ZkConnector();
		zk = zkConnector.connect("localhost");
		List<ACL> aclList = getAcl(path);
		for (ACL acl : aclList) {
			System.out.println(acl.toString());
		}
	}
}
