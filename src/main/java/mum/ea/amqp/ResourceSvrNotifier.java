package mum.ea.amqp;

import mum.ea.domain.Material;

public interface ResourceSvrNotifier {

	public String getPayload(Long materialID);
	public void savePayload(Material material);
	public void deletePayload(Long materialID);
}
