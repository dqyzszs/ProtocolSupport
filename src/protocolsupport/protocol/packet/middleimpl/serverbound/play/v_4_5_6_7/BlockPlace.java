package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleBlockPlace;
import protocolsupport.protocol.serializer.ItemStackSerializer;
import protocolsupport.protocol.serializer.PositionSerializer;
import protocolsupport.protocol.types.UsedHand;

public class BlockPlace extends MiddleBlockPlace {

	public BlockPlace(ConnectionImpl connection) {
		super(connection);
		hand = UsedHand.MAIN;
		insideblock = false;
	}

	@Override
	public void readFromClientData(ByteBuf clientdata) {
		PositionSerializer.readLegacyPositionBTo(clientdata, position);
		face = clientdata.readByte();
		ItemStackSerializer.readItemStack(clientdata, version);
		cX = clientdata.readUnsignedByte() / 16.0F;
		cY = clientdata.readUnsignedByte() / 16.0F;
		cZ = clientdata.readUnsignedByte() / 16.0F;
	}

}
