package packetPipelines;
import java.util.Comparator;

class PacketPipeline$1 implements Comparator<Class<? extends AbstractPacket>> {
    PacketPipeline$1(PacketPipeline this$0) {
        this.this$0 = this$0;
    }

    public int compare(Class<? extends AbstractPacket> clazz1, Class<? extends AbstractPacket> clazz2) {
        int com = String.CASE_INSENSITIVE_ORDER.compare(clazz1.getCanonicalName(), clazz2.getCanonicalName());
        if (com == 0) {
            com = clazz1.getCanonicalName().compareTo(clazz2.getCanonicalName());
        }

        return com;
    }
}
