package mx.edu.itspa.apis.notes.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import mx.edu.itspa.apis.notes.exception.NotFoundException;
import mx.edu.itspa.apis.notes.model.Note;
import mx.edu.itspa.apis.notes.model.NoteData;
import mx.edu.itspa.apis.notes.service.NotesService;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-18T22:01:45.408385500-08:00[America/Los_Angeles]")
@Controller
@RequestMapping("${openapi.notes.base-path:}")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RestApiController implements RestApi {

	private final NativeWebRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public RestApiController(NativeWebRequest request) {
		this.request = request;
	}

	@org.springframework.beans.factory.annotation.Autowired
	private NotesService notesService;

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<Void> createNote(NoteData data) {
		try {
			notesService.createNote(data);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity(buildError(status.name(), "Error creating a note"), status);
		}
	}

	@Override
	public ResponseEntity<List<Note>> getAllNotes() {
		try {
			List<Note> notes = notesService.getAll();
			return new ResponseEntity<>(notes, HttpStatus.OK);
		} catch (Exception e) {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity(buildError(status.name(), "Error retrieving notes"), status);
		}
	}

	@Override
	public ResponseEntity<Void> deleteNote(UUID id) {
		try {
			notesService.deleteNote(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (NotFoundException e) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity(buildError(status.name(), "Note not found"), status);
		} catch (Exception e) {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity(buildError(status.name(), "Error retrieving notes"), status);
		}
	}

	@Override
	public ResponseEntity<Note> getNoteById(UUID id) {
		try {
			Note note = notesService.getNoteById(id);
			return new ResponseEntity<>(note, HttpStatus.OK);
		} catch (NotFoundException e) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity(buildError(status.name(), "Note not found"), status);
		} catch (Exception e) {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity(buildError(status.name(), "Error retrieving note"), status);
		}
	}

	public ResponseEntity<Void> updateNote(UUID id, NoteData noteData) {
		try {
			notesService.updateNote(id, noteData);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (NotFoundException e) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity(buildError(status.name(), "Note not found"), status);
		} catch (Exception e) {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity(buildError(status.name(), "Error updating note"), status);
		}
	}

	private mx.edu.itspa.apis.notes.model.Error buildError(String code, String description) {
		return new mx.edu.itspa.apis.notes.model.Error().code(code).description(description);
	}
}
