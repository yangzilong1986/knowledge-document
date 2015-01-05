package com.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;

public class test {

    
	
	public static void main(String[] args) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "10.15.107.75");
		HBaseAdmin admin = new HBaseAdmin(conf);
		HTableDescriptor tableDescriptor = admin.getTableDescriptor(Bytes.toBytes("tag_friend"));
		byte[] name = tableDescriptor.getName();
		System.out.println(new String(name));
		HColumnDescriptor[] columnFamilies = tableDescriptor.getColumnFamilies();
		for (HColumnDescriptor d : columnFamilies) {
		    System.out.println(d.getNameAsString());
	    }
	}
}
