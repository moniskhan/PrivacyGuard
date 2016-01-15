package com.y59song.Network.IP;

import com.y59song.Network.TransportHeader;
import com.y59song.Utilities.ByteOperations;
import com.y59song.Utilities.MyLogger;

/**
 * Created by frank on 2014-03-26.
 */

public abstract class IPPayLoad {
  private static final String TAG = "IPPayLoad";
  protected TransportHeader header;
  protected byte[] data;

  public TransportHeader header() { return header; }
  public byte[] data() { return data; }
  public int getSrcPort() { return header.getSrcPort(); }
  public int getDstPort() { return header.getDstPort(); }

  public byte[] toByteArray() {
    return ByteOperations.concatenate(header.toByteArray(), data);
  }
  public int length() {
    return header.headerLength() + (data == null ? 0 : data.length);
  }
  public int dataLength() {
    return data == null ? 0 : data.length;
  }
  public int virtualLength() { return dataLength(); }

  protected byte[] getPseudoHeader(IPHeader ipHeader) {
    int length = length();
    return ipHeader.getPseudoHeader(length);
  }

  public void update(IPHeader ipHeader) {
    byte[] pseudoHeader = this.getPseudoHeader(ipHeader);
    header.setCheckSum(new byte[]{0, 0});
    byte[] toComputeCheckSum = ByteOperations.concatenate(pseudoHeader, header.toByteArray(), data);
    //MyLogger.debugInfo("TestCheckSum", ByteOperations.byteArrayToHexString(toComputeCheckSum));
    //MyLogger.debugInfo("TestCheckSum", ByteOperations.byteArrayToHexString(ByteOperations.computeCheckSum(toComputeCheckSum)));
    header.setCheckSum(ByteOperations.computeCheckSum(toComputeCheckSum));
  }
}
