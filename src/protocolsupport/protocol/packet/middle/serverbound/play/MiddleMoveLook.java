package protocolsupport.protocol.packet.middle.serverbound.play;

import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;

public abstract class MiddleMoveLook extends ServerBoundMiddlePacket {

	public MiddleMoveLook(ConnectionImpl connection) {
		super(connection);
	}

	protected double x;
	protected double y;
	protected double z;
	protected float yaw;
	protected float pitch;
	protected boolean onGround;

	@Override
	public void writeToServer() {
		codec.read(create(x, y, z, yaw, pitch, onGround));
	}

	public static ServerBoundPacketData create(double x, double y, double z, float yaw, float pitch, boolean onGround) {
		ServerBoundPacketData movelook = ServerBoundPacketData.create(PacketType.SERVERBOUND_PLAY_POSITION_LOOK);
		movelook.writeDouble(x);
		movelook.writeDouble(y);
		movelook.writeDouble(z);
		movelook.writeFloat(yaw);
		movelook.writeFloat(pitch);
		movelook.writeBoolean(onGround);
		return movelook;
	}
}
