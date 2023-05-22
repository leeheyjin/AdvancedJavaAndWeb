package chapter07;

public class DmbCellPhoneExample {
	public static void main(String[] args) {
		DmbCellPhone dmb = new DmbCellPhone("자바폰", "검정", 10);

		System.out.println("모델: " + dmb.model);
		System.out.println("색: " + dmb.color);
		System.out.println("채널: " + dmb.channel);

		System.out.println();
		dmb.powerOn();
		dmb.bell();
		System.out.println();
		dmb.sendVoice("여보세요?");
		System.out.println("뚱뚜둥 뚜둥 뚱 뚱 뚜두둥");
		dmb.sendVoice("여보세요?");
		System.out.println("뚜두두둥 둥 뚜둥 두둥 뚱 뚱 뚜두둥");
		dmb.sendVoice("하..");
		dmb.receiveVoice("예 럽이ㅅ페인 #!$@%@ 아 헤잇 디스 럽송 @$%@$ 그어 짓 말");
		dmb.receiveVoice("늦은 밤 비가 내려 와 널 데려ㄱ");
		dmb.hangUp();
		System.out.println();

		dmb.turnOnDmb();
		dmb.changeChannel(11);
		dmb.turnOffDmb();

	}

}
