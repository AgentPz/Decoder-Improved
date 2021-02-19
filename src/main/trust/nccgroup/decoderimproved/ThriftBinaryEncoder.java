package trust.nccgroup.decoderimproved;

import org.apache.thrift.TException;
import org.json.JSONObject;
import trust.nccgroup.readablethrift.ThriftCodec;
import trust.nccgroup.decoderimproved.modifiers.*;

public class ThriftBinaryEncoder implements ByteModifier {
    public String getModifierName() {
        return "Thrift Binary";
    }



public byte[] modifyBytes(byte[] input) throws ModificationException {
ThriftCodec codec = new ThriftCodec();
try {
String inputString = new String(input);
JSONObject inputJson = new JSONObject(inputString);
return codec.encode(inputJson);
} catch (TException e) {
throw new ModificationException(e.getMessage());
}
}
}