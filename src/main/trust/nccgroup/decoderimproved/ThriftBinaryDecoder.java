package trust.nccgroup.decoderimproved;

import org.apache.thrift.TException;
import trust.nccgroup.readablethrift.ThriftCodec;
import trust.nccgroup.decoderimproved.modifiers.*;
public class ThriftBinaryDecoder implements ByteModifier {

    public String getModifierName() {
            return "Thrift Binary";
}

    public byte[] modifyBytes(byte[] input) throws ModificationException {
        ThriftCodec codec = new ThriftCodec();
        try {
        return codec.decode(input).toString(4).getBytes();
}       catch (TException e) {
        throw new ModificationException(e.getMessage());
}
}
}