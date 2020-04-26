package by.mercury.core.strategy.impl;

import by.mercury.core.model.MessageModel;
import by.mercury.core.strategy.SynthesizeSpeechStrategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

import static java.lang.String.format;

public abstract class AbstractSynthesizeSpeechStrategy implements SynthesizeSpeechStrategy {

    protected static final String AUDIO_MESSAGE_PREFIX = "id_%d_";
    protected static final String DEFAULT_AUDIO_MESSAGE_EXTENSION = ".mp3";
    
    protected File createTempFile(MessageModel message) throws IOException {
        var filePrefix = format(AUDIO_MESSAGE_PREFIX, message.getTarget().getPeerId());
        return File.createTempFile(filePrefix, getFileExtension());
    }

    protected String getFileExtension() {
        return DEFAULT_AUDIO_MESSAGE_EXTENSION;
    }

    protected File save(File file, byte[] audio) {
        try (var outputStream = new FileOutputStream(file)) {
            outputStream.write(audio);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
        return file;
    }
}
