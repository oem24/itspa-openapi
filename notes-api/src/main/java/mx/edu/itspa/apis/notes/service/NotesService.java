package mx.edu.itspa.apis.notes.service;

import java.util.List;
import java.util.UUID;

import mx.edu.itspa.apis.notes.exception.NotFoundException;
import mx.edu.itspa.apis.notes.model.Note;
import mx.edu.itspa.apis.notes.model.NoteData;


public interface NotesService {
	
	public Note getNoteById(UUID id) throws NotFoundException;
	
	public List<Note> getAll();
	
	public void createNote(NoteData note);
	
	public void updateNote(UUID id, NoteData note) throws NotFoundException;
	
	public void deleteNote(UUID id) throws NotFoundException;
}
