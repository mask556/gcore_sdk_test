package com.example.gcore_sdk_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import gcore.videocalls.meet.GCoreMeet
import gcore.videocalls.meet.model.LocalState
import gcore.videocalls.meet.ui.view.me.LocalVideoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Определяем параметры и методы для коннекта к серверу
        // в App

        // в ридми проекта
//        GCoreMeet.instance.clientHostName = "studio.gvideo.co"
//        GCoreMeet.instance.roomManager.displayName = "John Snow"
//        GCoreMeet.instance.setRoomId("serv01234")
//        GCoreMeet.instance.roomManager.peerId = "user09876"
        // в тестовом приложении
        setGMeetParams()
        setConnectionParams()

        // Перед присоединением к комнате нужно подключится
        GCoreMeet.instance.startConnection(this) // ------------------------------------------


        val roomManager = GCoreMeet.instance.roomManager
        // Перед подключением к окманте можем установить настройки для аудио и видео
        roomManager.options.startWithCam = true
        roomManager.options.startWithMic = true
        // Присоединение к комнате
        if (roomManager.isClosed()) {
            roomManager.join()
        }

        // Подписываемся
        //Изменеие состояния подключения
        // roomManager.roomProvider.connected
        //Список всех пиров в комнате
        // roomManager.roomProvider.peers
        //или
        // GCoreMeet.instance.getPeers()
        //Состояние комнаты
//        roomManager.roomProvider.roomInfo.observeForever { roomInfo ->
//            roomInfo.activeSpeakerIds   //Разговаривающие в данный момент участники
//            roomInfo.connectionState    //Сшостояние комнаты
//        }

        //Локальное состояние
//        roomManager.roomProvider.me.observeForever { localState: LocalState ->
//
//        }

//        val localVideo = findViewById<LocalVideoView>(R.id.local_video)
//        localVideo.connect()

//        val peerVideoView = findViewById<LocalVideoView>(R.id.peer_video_view)
//        peerVideoView.connect(peer.id)

    }

    fun setGMeetParams(
        webRtcHost: String = "webrtc1.youstreamer.com",
        port: Int = 443,
        clientHostName: String = "https://meet.gcorelabs.com",
        hostName: String = "meet.gcorelabs.com",
    ) {
        GCoreMeet.instance.webRtcHost = webRtcHost
        GCoreMeet.instance.port = port
        GCoreMeet.instance.clientHostName = clientHostName
        GCoreMeet.instance.hostName = hostName
    }


    fun setConnectionParams(
        clientHostName: String = "https://meetv2.youstreamer.com",
        roomId: String = "eybLN",
        participantName: String = "nnn",
        participantId: String? = null,
    ) {
        GCoreMeet.instance.clientHostName = clientHostName
        GCoreMeet.instance.setRoomId(roomId)
        GCoreMeet.instance.roomManager.displayName = participantName
        // if not filled, auto generation
        if (participantId != null) {
            GCoreMeet.instance.roomManager.peerId = participantId
        }
    }

}