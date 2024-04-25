package ru.mirea.bakiev.mireaproject;

import android.content.pm.PackageManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import ru.mirea.bakiev.mireaproject.databinding.FragmentCameraBinding;
import ru.mirea.bakiev.mireaproject.databinding.FragmentMicrophoneBinding;

public class MicrophoneFragment extends Fragment {
    //private	ActivityMainBinding	binding;
    private	static	final	int	REQUEST_CODE_PERMISSION	=	200;
    private	final	String	TAG	=	MainActivity.class.getSimpleName();
    private	boolean	isWork;
    private	String	fileName	=	null;
    private Button recordButton	=	null;
    private	Button	playButton	=	null;
    private MediaRecorder recorder	=	null;
    private MediaPlayer player	=	null;
    boolean	isStartRecording	=	true;
    boolean	isStartPlaying	=	true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMicrophoneBinding binding = FragmentMicrophoneBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        int	audioRecordPermissionStatus	=	ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.RECORD_AUDIO);
        int	storagePermissionStatus	=	ContextCompat.checkSelfPermission(getActivity(),	android.Manifest.permission.
                WRITE_EXTERNAL_STORAGE);
        if	(audioRecordPermissionStatus	==	PackageManager.PERMISSION_GRANTED	&&	storagePermissionStatus
                ==	PackageManager.PERMISSION_GRANTED)	{
            isWork	=	true;
        }	else	{
            //	Выполняется	запрос	к	пользователь	на	получение	необходимых	разрешений
            ActivityCompat.requestPermissions(getActivity(),	new	String[]	{android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE},	REQUEST_CODE_PERMISSION);
        }

        // инициализация кнопок записи и воспроизведения
        recordButton	=	binding.recordButton;
        playButton	=	binding.playButton;
        playButton.setEnabled(false);
        fileName = (new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_MUSIC),
                "/audiorecordtest.3gp")).getAbsolutePath();

        recordButton.setOnClickListener(new	View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStartRecording) {
                    recordButton.setText("Stop	recording");
                    playButton.setEnabled(false);
                    startRecording();
                } else {
                    recordButton.setText("Start	recording");
                    playButton.setEnabled(true);

                    recorder.stop();
                    recorder.release();
                    recorder = null;

                    Uri uri = Uri.parse(fileName);
                    MediaMetadataRetriever mmr = new MediaMetadataRetriever();
                    mmr.setDataSource(getContext(),uri);
                    String durationStr = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

                    binding.timeText.setText(durationStr + " millisecond");
                }

                isStartRecording = !isStartRecording;
            }
        });

        playButton.setOnClickListener(new	View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStartPlaying) {
                    playButton.setText("Stop playing");
                    recordButton.setEnabled(false);
                    startPlaying();
                } else {
                    playButton.setText("Start playing");
                    recordButton.setEnabled(false);
                    stopPlaying();
                }

                isStartPlaying = !isStartPlaying;
            }
        });

        return view;
    }

    @Override
    public	void	onRequestPermissionsResult(int	requestCode, @NonNull String[]	permissions, @NonNull	int[]
            grantResults)	{
        //	производится	проверка	полученного	результата	от	пользователя	на	запрос	разрешения	Camera
        super.onRequestPermissionsResult(requestCode,	permissions,	grantResults);
        switch	(requestCode){
            case	REQUEST_CODE_PERMISSION:
                isWork		=	grantResults[0]	==	PackageManager.PERMISSION_GRANTED;
                break;
        }
        if	(!isWork	)	getActivity().finish();
    }

    private	void startRecording()	{
        recorder	=	new	MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try	{
            recorder.prepare();
        }	catch	(IOException e)	{
            Log.e(TAG,	"prepare()	failed");
        }
        recorder.start();
    }

    private	void startPlaying()	{
        player	= new	MediaPlayer();
        try	{
            player.setDataSource(fileName);
            player.prepare();
            player.start();
        }	catch	(IOException	e)	{
            Log.e(TAG,	"prepare()	failed");
        }
    }

    private	void stopPlaying()	{
        player.release();
        player	=	null;
    }
}