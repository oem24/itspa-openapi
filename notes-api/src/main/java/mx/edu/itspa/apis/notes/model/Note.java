package mx.edu.itspa.apis.notes.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Note
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-18T22:01:45.408385500-08:00[America/Los_Angeles]")
public class Note   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("createdOn")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdOn;

  @JsonProperty("content")
  private String content;

  @JsonProperty("title")
  private String title;

  @JsonProperty("priority")
  private Integer priority = 0;

  public Note id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for this note
   * @return id
  */
  @ApiModelProperty(required = true, value = "Unique identifier for this note")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Note createdOn(OffsetDateTime createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * Timestamp when this note was created.
   * @return createdOn
  */
  @ApiModelProperty(example = "2021-01-30T08:30Z", required = true, value = "Timestamp when this note was created.")
  @NotNull

  @Valid

  public OffsetDateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(OffsetDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public Note content(String content) {
    this.content = content;
    return this;
  }

  /**
   * The content of the note
   * @return content
  */
  @ApiModelProperty(example = "Note content", required = true, value = "The content of the note")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Note title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The title of the note
   * @return title
  */
  @ApiModelProperty(example = "Note title", required = true, value = "The title of the note")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Note priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Priority of the Note. (for sorting)
   * @return priority
  */
  @ApiModelProperty(required = true, value = "Priority of the Note. (for sorting)")
  @NotNull


  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Note note = (Note) o;
    return Objects.equals(this.id, note.id) &&
        Objects.equals(this.createdOn, note.createdOn) &&
        Objects.equals(this.content, note.content) &&
        Objects.equals(this.title, note.title) &&
        Objects.equals(this.priority, note.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdOn, content, title, priority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Note {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

